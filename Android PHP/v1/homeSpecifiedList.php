<?php

require_once '../includes/DbOperations.php';

$response = array();

if($_SERVER['REQUEST_METHOD']=='POST'){
  if(
			isset($_POST['minRent']) and
				isset($_POST['maxRent'])and
  				isset($_POST['numRooms'])and
    				isset($_POST['requiredGender']))
		{

    $db = new DbOperations();
    $specifiedHome = $db->showSpecifiedHomes($_POST['minRent'], $_POST['maxRent'], $_POST['numRooms'], $_POST['requiredGender']);

    $response['error'] = false;
    $response['homeID'] = $specifiedHome['Home_ID'];
    $response['address'] = $specifiedHome['Address'];
    $response['rooms'] = $specifiedHome['Rooms'];
    $response['gender'] = $specifiedHome['	Gender'];
    $response['rent'] = $specifiedHome['Rent'];
    $response['description'] = $specifiedHome['Description'];
    $response['owner'] = $specifiedHome['Owner_ID'];
    $response['homeDate'] = $specifiedHome['reg_date'];


    }else {
      $response['error'] = true;
  		$response['message'] = "Required fields are missing";
    }
    }else {
      $response['error'] = true;
      $response['message'] = "Invalid Request";
    }

      echo json_encode($response);
