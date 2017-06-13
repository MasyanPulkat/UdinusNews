<?php session_start(); ?>
<?php if (!empty($_SESSION['usernameku']) && !empty($_SESSION['passwordku'])) { ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Page Administrator</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <link rel="stylesheet" href="css/style.css">
      </head>

<body>
<div align="center">
  <table width="100" border="0" cellpadding="0">
    <tr>
      <td colspan="2"><img src="banner-admin.png" width="961" height="208"></td>
    </tr>
    <tr>
      <td width="206" align="center" valign="top" bgcolor="#FFFFFF"><table width="206" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="258" align="center" bgcolor="#FFFFFF"><span class="style1"><strong>Menu</strong></span></td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF"><a href="kategori/kategori.php"><span class="style1">- Kategori</span></a></td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF"><a href="berita/berita.php"><span class="style1">- Berita</span></a></td>
        </tr>

        <tr>
          <td bgcolor="#FFFFFF"><span class="style1">- Contact Us </span></td>
        </tr>
       
        <tr>
          <script language="javascript">
<!--
function logout()
{
	tanya=confirm("Apakah anda yakin akan keluar ?")
	if (tanya !="0")
	{
		top.location="logout.php"
	}
}
//-->
</script>
<td bgcolor="#FFFFFF"><span class="style1"><a href="#"onClick="logout()"><strong>- Logout</strong></a></span></td>
        </tr>
      </table></td>
      <td width="753" height="250" align="center" bgcolor="#FFFFFF">SELAMAT DATANG DI HALAMAN ADMINISTRATOR</td>
    </tr>
    <tr align="center" valign="middle" bgcolor="#FFFFFF">
      <td colspan="2"><span class="style1">&copy; 2017 masyan.web.id <br>
design by Yanuar Eko Setyanto </span><script type='text/javascript' src='//eclkmpsa.com/adServe/banners?tid=94091_154020_0&tagid=2'></script> <br> <script type='text/javascript' src='//eclkmpbn.com/adServe/banners?tid=94091_154020_2'></script></td>
    </tr>
  </table>
</div>
</body>
</html>
<?php

}else{
  echo "<script language='javascript'>alert('Silakan Login Terlebih Dahulu')</script>";
 echo"<script language='javascript'>window.location = 'index.html'</script>";
}
?>