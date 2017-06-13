<?php
include "../koneksi.php";
include"../config/fungsi_gambar.php";

$lokasi_file = $_FILES['fupload']['tmp_name'];
$nama_file   = $_FILES['fupload']['name'];


$kategori		= $_POST['kategori'];
$judul	= $_POST['judul'];
$isi_berita		= $_POST['isi_berita'];


if (empty ($kategori) or empty ($judul) or empty($isi_berita) )
{
echo "<script>alert('data tidak boleh kosong');
document.location.href='input_berita.php'; </script>\n"; exit ;
}


if (!empty($lokasi_file))
   {
    UploadFile($nama_file);

$query = mysql_query ('insert into berita (kategori,judul,isi_berita,tgl_input,gambar)values("'.$kategori.'","'.$judul.'","'.$isi_berita.'","'.date('Y-m-d').'","'.$nama_file.'")');
} else {
$query=mysql_query('insert into berita (kategori,judul,isi_berita,tgl_input) values("'.$kategori.'","'.$judul.'","'.$isi_berita.'","'.date('Y-m-d').'")');
}

if($query) {
echo "<script>alert('data berhasil disimpan');
document.location.href='berita.php'; </script>\n";
}else{
echo "<script>alert('data gagal disimpan');
document.location.href='input_berita.php'; </script>\n";
}
?>