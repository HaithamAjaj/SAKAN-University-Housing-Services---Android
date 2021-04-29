<?php


	class DbOperations{

		private $con;

		function __construct(){

			require_once dirname(__FILE__).'/DbConnect.php';

			$db = new DbConnect();

			$this->con = $db->connect();

		}



		/*CRUD -> C -> CREATE */

		public function createUser($username, $gender, $email, $phone_num, $pass){
			if($this->isUserExist($username,$email)){
				return 0;
			}else{
				$password = md5($pass);
				$stmt = $this->con->prepare("INSERT INTO app_user (User_ID, Full_Name, Gender, phone_num, email, pass_word) VALUES (NULL, ?, ?, ?, ?, ?);");
				$stmt->bind_param("ssiss",$username,$gender,$phone_num,$email,$password);

				if($stmt->execute()){
					return 1;
				}else{
					return 2;
				}
			}
		}

		public function userLogin($username, $pass){
			$password = md5($pass);
			$stmt = $this->con->prepare("SELECT User_ID FROM app_user WHERE Full_Name = ? AND pass_word = ?;");
			$stmt->bind_param("ss",$username,$password);
			$stmt->execute();
			$stmt->store_result();
			return $stmt->num_rows > 0;
		}

		public function getUserByUsername($username){
			$stmt = $this->con->prepare("SELECT * FROM User_ID WHERE Full_Name = ?;");
			$stmt->bind_param("s",$username);
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}


		private function isUserExist($username, $email){
			$stmt = $this->con->prepare("SELECT User_ID FROM app_user WHERE Full_Name = ? OR email = ?;");
			$stmt->bind_param("ss", $username, $email);
			$stmt->execute();
			$stmt->store_result();
			return $stmt->num_rows > 0;
		}

		public function addHome($Address, $Rooms, $Gender, $Rent, $Description, $Owner_ID){

			$stmt = $this->con->prepare("INSERT INTO homes (	Home_ID, 	Address, Rooms, Gender, Rent, Description, Owner_ID) VALUES (NULL, ?, ?, ?, ?, ?, ?);");
			$stmt->bind_param("sisisi",$Address,$Rooms,$Gender,$Rent,$Description,$Owner_ID);
			if($stmt->execute()){
				return 1;
			}else{
				return 2;
			}
		}

		public function changeName($userID, $newName){

			$stmt = $this->con->prepare("UPDATE app_user SET Full_Name = ? where User_ID = ?;");
			$stmt->bind_param("si", $newName, $userID);
			if($stmt->execute()){
				return 1;
			}else{
				return 2;
			}
		}

		public function changePhone($userID, $newPhoneNum){

			$stmt = $this->con->prepare("UPDATE app_user SET phone_num = ? where User_ID = ?;");
			$stmt->bind_param("ii", $newPhoneNum, $userID);
			if($stmt->execute()){
				return 1;
			}else{
				return 2;
			}
		}

		public function changePassword($userID, $newPassword){

			$stmt = $this->con->prepare("UPDATE app_user SET pass_word = ? where User_ID = ?;");
			$stmt->bind_param("si", $newPassword, $userID);
			if($stmt->execute()){
				return 1;
			}else{
				return 2;
			}
		}

		public function changeEmail($userID, $newEmail){

			$stmt = $this->con->prepare("UPDATE app_user SET email = ? where User_ID = ?;");
			$stmt->bind_param("si", $newEmail, $userID);
			if($stmt->execute()){
				return 1;
			}else{
				return 2;
			}
		}

		public function showHomes(){

			$stmt = $this->con->query("SELECT * FROM homes;");
			$homeArray = array();
    while($row = $stmt->fetch_assoc())
    {
        $homeArray[] = $row;
    }
		return $homeArray;
		}

		public function showSpecifiedHomes($minRent, $maxRent, $numRooms, $requiredGender){

			$stmt = $this->con->prepare("SELECT * FROM homes Where Rent >= ? AND Rent <= ? AND Gender = ? AND Rooms = ?;");
			$stmt->bind_param("iisi", $minRent, $maxRent, $requiredGender, $numRooms);
			$stmt->execute();
			$stmt->store_result();

			$homeSpecifiedArray = array();
		while($row = $stmt->fetch_assoc())
    {
        	$homeSpecifiedArray[] = $row;
    }
		return 	$homeSpecifiedArray;
		}



	}
