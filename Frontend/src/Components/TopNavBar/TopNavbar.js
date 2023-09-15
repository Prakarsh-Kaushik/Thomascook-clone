import React,{useState} from 'react'
import "./TopNavbar.css"
import "bootstrap/dist/css/bootstrap.min.css";
import { Link, useNavigate } from 'react-router-dom';
const TopNavbar = () => {
    const navigate = useNavigate();

    const handleLogin=()=>{
        navigate("/login")
        setLoggedIn(false);
    }
    const handleRegister = ()=>{
        navigate("/register")
    }
    const [loggedIn,setLoggedIn] = useState(true);
  return (
   <>
   <div className='container2'>
   <div className='btn btn-primary bt' onClick={handleRegister}>Register New User</div>
 {loggedIn && <div className='btn btn-primary bt'onClick={handleLogin}>Login</div>}

 
 <Link to="/myprofile"><div className='btn btn-primary bt'>My Profile</div></Link> 
  </div>
   </>
  )
}

export default TopNavbar