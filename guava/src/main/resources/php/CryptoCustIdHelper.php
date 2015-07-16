<?php
ERROR_REPORTING(0);
$email = base64_decode($argv[1]);
$strArray = iconv('gb2312','utf-8//IGNORE','cookie_crypto_key_initial'.$email);
$custid= dang_decrypt_text($argv[2], $strArray);
echo $custid;



            /*---------------------------------------*\
            | 函数作用：返回一个字符串md5之后的字符串 |
            | $strArray：字符串类型                   |
            \*---------------------------------------*/
            function MakeMD5($strArray) {
                    $sb = md5($strArray);
                    $sb = pack('H*',$sb);
                    return $sb;
            }

            /*---------------------------------------------*\
            | 函数作用：对.net的3DES加密的字符串进行解密    |
            | $key：加密时候使用的key                       |
            | $iv：初始向量                                 |
            | $text：需要解密的字符串                       |
            \*---------------------------------------------*/
            function decryptNET3DES($key,$iv,$text){
                    if(empty($text)) return "";
                    $td = mcrypt_module_open(MCRYPT_3DES, '', MCRYPT_MODE_ECB, '');

                    // 把key值补充完整，在PHP里面如果key值不够24位剩下的会自动补0，但是在.net中，会做一个循环把前面的值补充到后面补够24位，所以这里强制补前面的字符
                    $key_add = 24-strlen($key);
                    $key .= substr($key,0,$key_add);

                    mcrypt_generic_init($td, $key, $iv);
                    $decrypt_text = mdecrypt_generic($td, $text);
                    mcrypt_generic_deinit($td);
                    mcrypt_module_close($td);

                    //去掉padding的尾巴，因为.net中默认的padding是PKCS7，而php中默认的padding是zero，所以在.net使用默认的情况下，要将php程序的padding重新设置
                    $block = mcrypt_get_block_size('tripledes', 'ecb');
                    $packing = ord($decrypt_text{strlen($decrypt_text)-1});
                    if($packing and ($packing < $block))
                    {
                            for($P=strlen($decrypt_text)-1; $P>=strlen($decrypt_text)-$packing; $P--)
                            {
                                    if(ord($decrypt_text{$P}) != $packing)
                                    {
                                            $packing = 0;
                                    }
                            }
                    }
                    $decrypt_text = substr($decrypt_text,0,strlen($decrypt_text) - $packing);
                    return $decrypt_text;
            }

            //解密
            function dang_decrypt_text($text,$key){
                    $strArray = trim($key);
                    $iv = mcrypt_create_iv(mcrypt_get_iv_size(MCRYPT_3DES,MCRYPT_MODE_ECB),MCRYPT_RAND);
                    $key_string = MakeMD5(base64_encode(MakeMD5($strArray)));
                    $encry_string = base64_decode($text);
                    $result = decryptNET3DES($key_string,$iv,$encry_string);
                    return $result ;
            }

?>