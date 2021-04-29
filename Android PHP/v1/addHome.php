<?php

require_once '../includes/DbOperations.php';

$response = array();

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(
		isset($_POST['Address']) and
			isset($_POST['Rooms']) and
				isset($_POST['Gender'])and
  				isset($_POST['Rent'])and
    				isset($_POST['Description'])){

              	$db = new DbOperations();

                $result = $db->addHome( 	$_POST['Address'],
            									$_POST['Rooms'],
            									$_POST['Gender'],
            									$_POST['Rent'],
            									$_POST['Description'],
                              $_POST['Owner_ID']
            								);
            		if($result == 1){
            			$response['error'] = false;
            			$response['message'] = "Home Added successfully";
            		}elseif($result == 2){
            			$response['error'] = true;
            			$response['message'] = "Some error occurred please try again";
            		}



            }else{
              $response['error'] = true;
          		$response['message'] = "Required fields are missing";
            }
          }else{
            $response['error'] = true;
          	$response['message'] = "Invalid Request";
          }

          echo json_encode($response);
