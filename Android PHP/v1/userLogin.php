<?php

require_once '../includes/DbOperations.php';

$response = array();

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['username']) and isset($_POST['password'])){
		$db = new DbOperations();

		if($db->userLogin($_POST['username'], $_POST['password'])){
			$user = $db->getUserByUsername($_POST['username']);
			$response['error'] = false;
			$response['id'] = $user['User_ID'];
      $response['username'] = $user['Full_Name'];
      $response['gender'] = $user['Gender'];
			$response['phoneNum'] = $user['phone_num'];
      $response['email'] = $user['email'];
      $response['password'] = $user['pass_word'];
      $response['userDate'] = $user['Reg_date'];

		}else{
			$response['error'] = true;
			$response['message'] = "Invalid username or password";
		}

	}else{
		$response['error'] = true;
		$response['message'] = "Required fields are missing";
	}
}

echo json_encode($response);
