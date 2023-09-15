import React, { useState } from 'react'
import axios from 'axios'
import { getLocation } from '../../services/user-service'
import { privateAxios } from '../../services/helper'
import "./Register.css"
import { ToastContainer, toast } from 'react-toastify';

const Register = () => {
  
 const data = {
  firstName:"",
   lastName:"",
  age: "",
  sex:"",
  emailId:"",
  contact:"",
  street: "",
  password:"",
  city:"",
  pincode:"",
  password: "",
  role: "ROLE_admin",

}
const [inputData,setInputData] = useState(data)
const handleData = (e)=>{

  setInputData({...inputData, [e.target.name]:e.target.value})
}
const handleSubmit = (e) => {
  e.preventDefault();
  axios.post("http://localhost:8080/api/user/register",inputData)
  .then(()=>
  toast.success(`Registered Successfully`, {
    position: "top-right",
    autoClose: 3000,
    hideProgressBar: false,
    closeOnClick: true,
    pauseOnHover: true,
    draggable: true,
    progress: undefined,
    theme: "dark",
  }
  )
  )
  
    
  }





  return (
  <>


<div class="wrapper">
    <div class="title">
      Registration Form
    </div>
    <div class="form">
       <div class="inputfield">
          <label>First Name</label>
          <input type="text" name="firstName"  value={inputData.firstName} onChange={handleData} className="input"/>
       </div>  
        <div class="inputfield">
          <label>Last Name</label>
          <input type="text" class="input" name="lastName" value={inputData.lastName} onChange={handleData}/>
       </div>  
       <div class="inputfield">
          <label>Age</label>
          <input type="number" class="input"  name="age" value={inputData.age} onChange={handleData}/>
       </div>  
       <div class="inputfield">
          <label>Email Address</label>
          <input input type="email" name="emailId"  value={inputData.emailId} onChange={handleData} class="input"/>
       </div> 
       <div class="inputfield">
          <label>Password</label>
          <input type="password" class="input"  name="password" value={inputData.password} onChange={handleData}/>
       </div>  
     
        <div class="inputfield">
          <label>Gender</label>
          <input type="text" class="input" name="sex" value={inputData.sex} onChange={handleData}/>
          </div>
     
        
      <div class="inputfield">
          <label>Phone Number</label>
          <input type="text" class="input" name="contact" value={inputData.contact} onChange={handleData}/>
       </div> 
       <div class="inputfield">
          <label>City</label>
          <input type="text" class="input" name="city" value={inputData.city} onChange={handleData}/>
       </div> 
      <div class="inputfield">
          <label>Street</label>
          <input type="text" class="input" name="street" value={inputData.street} onChange={handleData}/>
       </div> 
      <div class="inputfield">
          <label>Postal Code</label>
          <input type="text" class="input" name="pincode" value={inputData.pincode} onChange={handleData}/>
       </div> 
    
      <div class="inputfield terms">
          <label class="check">
            <input type="checkbox"/>
            <span class="checkmark"></span>
          </label>
       
          <p>   Agree to terms and conditions</p>
       </div> 
      
      <div class="inputfield">
      <button type="button" onClick={handleSubmit} className='btn'> Register</button>
      </div>
    </div>
    </div> 
<ToastContainer/>
</>
  )
}

export default Register;