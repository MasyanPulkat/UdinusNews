<?php 
	include 'config.php';
	if(isset($_GET['id_berita'])){
		$kd=$_GET['id_berita'];
	}
	$sql =mysql_query("select * from berita where id_berita = $kd") or die(mysql_error());
	$response = array();
	$cek = mysql_num_rows($sql);
		if($cek > 0)
		{
			$response["berita"]	=array();
			while ($row= mysql_fetch_array($sql)) {
				$data=array();
				$data["id"]		=	$row["id_berita"];
				$data["judul"]	=	$row["judul"];
				$data["isi"]	=	$row["isi_berita"];
				$data["gambar"]	=	$row["gambar"];
				array_push($response["berita"], $data);
			}
			$response["success"]	= 1;
			$response["message"]	= "Detail data berita";
			echo json_encode($response);
		}else
		{
			$response["success"]	= 0;
			$response["message"]	= "Detail data berita gagal";
			echo json_encode($response);

		}

 ?>