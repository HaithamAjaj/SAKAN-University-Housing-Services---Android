<?php

require_once '../includes/DbOperations.php';

if($_SERVER['REQUEST_METHOD']=='POST'){
  if(isset($_POST['userID']) and isset($_POST['newPassword'])){

    	$db = new DbOperations();
      $result = db->changePassword($_POST['userID'], $_POST['newPassword']);

      if($result == 1){
        $response['error'] = false;
        $response['message'] = "password Changed successfully";
      }elseif($result == 2){
        $response['error'] = true;
        $response['message'] = "Some error occurred please try again";
      }


  }else {
    $response['error'] = true;
		$response['message'] = "Required fields are missing";
  }

}else {
  $response['error'] = true;
  $response['message'] = "Invalid Request";
}

echo json_encode($response);
