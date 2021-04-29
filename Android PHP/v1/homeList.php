<?php

require_once '../includes/DbOperations.php';

$response = array();

if($_SERVER['REQUEST_METHOD']=='POST'){
		$db = new DbOperations();

			$home = $db->showHomes();
			$response['error'] = false;
			$response['homeID'] = $home['Home_ID'];
      $response['address'] = $home['Address'];
      $response['rooms'] = $home['Rooms'];
			$response['gender'] = $home['	Gender'];
      $response['rent'] = $home['Rent'];
      $response['description'] = $home['Description'];
      $response['owner'] = $home['Owner_ID'];
      $response['homeDate'] = $home['reg_date'];
    }

    echo json_encode($response);
