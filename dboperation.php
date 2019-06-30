<?php
	class DbOperation{

		private $con;

		function __construct(){

			require_once dirname(__FILE__).'/connect.php';
			$db = new DbConnect();
			$this ->con = $db->connect();
		}

		function createuser($Firstname,$Lastname,$Degree,$Experience,$username,$passwd)
		{
			$pass = md5($passwd);
			$stmt = $this->con->prepare("INSERT INTO 'skin'('Firstname','Lastname','Degree','Experience','username','passwd') VALUES (?,?,?,?,?,?);");
			$stmt->bind_param("ssssss",$Firstname,$Lastname,$Degree,$Experience,$username,$pass);


			if($stmt->execute());

			{
				return true;
			}
			else
			{
				return false;
			}
		}

	}
?>