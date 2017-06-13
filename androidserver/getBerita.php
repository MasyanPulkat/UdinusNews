<?php 
	include 'config.php';
	$sql =mysql_query("select * from berita") or die(mysql_error());
	$response = array();
	$cek = mysql_num_rows($sql);
		if($cek > 0)
		{
			$response["berita"]	=array();
			while ($row= mysql_fetch_array($sql)) {
				$data=array();
				$data["id"]		=	$row["id_berita"];
				$data["judul"]	=	$row["judul"];
				$data["gambar"]	=	$row["gambar"];
				array_push($response["berita"], $data);
			}
			$response["success"]	= 1;
			$response["message"]	= "Semua data berita";
			echo json_encode($response);
		}else
		{
			$response["success"]	= 0;
			$response["message"]	= "Data berita gagal";
			echo json_encode($response);
		}
 ?>