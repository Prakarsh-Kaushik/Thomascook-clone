import React, { useEffect, useState } from 'react'
import "./myProfile.css";
import { privateAxios } from '../services/helper';
const MyProfile = () => {
  const [userData,setUserData] = useState();

  const fetchUserData = async() =>{
   const response= await privateAxios.get("http://localhost:8080/api/user/id?userId=1");
   setUserData(response.data.user)

  }
  
  useEffect(()=>{
    fetchUserData();
  },[])
  return (
    <>
{userData &&
<div class="wrapper1">
    <div class="left">
        <img src="https://w0.peakpx.com/wallpaper/689/805/HD-wallpaper-whatsapp-dp-walpaper-beauty-cartoon-cartoon-walpaper-walpaper-zkpanezai-thumbnail.jpg" 
        alt="user" width="100"/>
        <h4>{userData.firstName}</h4>
         <p>{userData.city}</p>
    </div>
    <div class="right">
        <div class="info">
            <h3>Information</h3>
            <div class="info_data">
                 <div class="data">
                    <h4>Email</h4>
                    <p >{userData.emailId}</p>
                 </div>
                 <div class="data">
                   <h4>Phone</h4>
                    <p>{userData.contact}</p>
              </div>
            </div>
        </div>
      
      <div class="projects">
       
            <div class="projects_data">
                 <div class="data">
                    <h4>Street</h4>
                    <p>{userData.street}</p>
                 </div>
                 <div class="data">
                   <h4>Gender</h4>
                    <p>{userData.sex}</p>
              </div>
            </div>
        </div>
      
      
    </div>
</div>
}
    
    
    </>

  )
}

export default MyProfile