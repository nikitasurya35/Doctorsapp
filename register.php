<?php

require_once'../includes/DbOperation.php';

$response = array();

if($_SERVER['REQUEST_METHOD']=='POST')
{
	if (isset($_POST['Firstname']) and isset($_POST['Lastname'] )and isset($_POST['Degree']) and isset($_POST['Experience']) and isset($_POST['username'] )and isset($_POST['passwd'])) 
	{
		# code..
		$db = new DbOperation();

		if ($db->createuser($_POST['Firstname'],$_POST['Lastname'],$_POST['Degree'],$_POST['Experience'],$_POST['username'],$_POST['passwd'])) 
		{

			$response['error'] = false;
			$response['message'] = "User registration success...";

			# code...
		}
		else
		{
			$response['error'] = true;
			$response['message'] = "failed...plz try again..";
		}
		
		

	}
	else
	{
		$response['error'] = true;
		$response['message'] = "required feilds are missing..";
	}
	
}else
	{
		$response['error'] = true;
		$response['message'] = "invalid request...";

	}

echo json_encode($response);