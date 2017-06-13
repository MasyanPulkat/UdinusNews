<?php session_start(); ?>
<?php if (!empty($_SESSION['usernameku']) && !empty($_SESSION['passwordku'])) { ?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Halaman Admin</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <link rel="stylesheet" href="../css/style.css">
      </head>

<body>
<div align="center">
  <table width="100" border="0" cellpadding="0">
    <tr>
      <td colspan="2"><img src="../banner-admin.png" width="961" height="208"></td>
    </tr>
    <tr>
      <td width="206" align="center" valign="top" bgcolor="#FFFFFF"><table width="206" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="258" align="center" bgcolor="#FFFFFF"><span class="style1"><strong>Menu</strong></span></td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF"><a href="kategori.php"><span class="style1">- Kategori</span></a></td>
        </tr>
        <tr>
          <td bgcolor="#FFFFFF"><a href="../berita/berita.php"><span class="style1">- Berita</span></a></td>
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
		top.location="../logout.php"
	}
}
//-->
</script>
<td bgcolor="#000048"><span class="style1"><a href="#"onClick="logout()"><strong>- Logout</strong></a></span></td>
        
        </tr>
      </table></td>
      <td width="753" height="250" align="left" bgcolor="#FFFFFF"><div align="center">INPUT KATEGORI BERITA
        </div>
        <table width="755" border="0">
        <tr>
          <td width="27">&nbsp;</td>
          <td width="702">&nbsp;</td>
          <td width="10">&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><p align="left"><form enctype="multipart/form-data" method="post" action="update_kategori.php?&id=<?php echo $_GET['id'] ?>">
    <table border="0">
      <?php 
  include "../koneksi.php";
  
  $id		= $_GET['id'];
  $edit		= "select * from kategori where id_kategori=$id";
  $hasil	= mysql_query ($edit);
  $c		= mysql_fetch_array ($hasil);
  ?>
      <tr>
        <td width="144"><small>KATEGORI </small></td>
        </tr>
      <tr>
        <td><input name="kategori" type="text" id="kategori"  value="<?php echo $c['nama_kategori']?>"></td>
        </tr>
      <tr>
        <td align="right"><input type="submit" name="submit" value="simpan"></td>
        </tr>
    </table>
  </form>
            </p>
<p></p></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table></td>
    </tr>
    <tr align="center" valign="middle" bgcolor="#FFFFFF">
      <td colspan="2"><span class="style1">&copy; 2017 masyan.web.id <br>
Yanuar Eko Setyanto </span></td>
    </tr>
  </table>
</div>
</body>
</html>
<?php

}else{
  echo "<script language='javascript'>alert('Silakan Login Terlebih Dahulu')</script>";
 echo"<script language='javascript'>window.location = '../index.php'</script>";
}
?>