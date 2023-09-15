import React,{useState} from 'react'
import { loginUser } from '../../services/user-service';
import { doLogin } from './Auth';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';
import "./login.css"

const Login = () => {
    const [loginDetail, setLoginDetail] = useState({
        emailId: "",
        password: "",
        role:"ROLE_admin",

      });
      const navigate = useNavigate();

      const handleChange = (event, field) => {
        let actualValue = event.target.value;
        setLoginDetail({
          ...loginDetail,
          [field]: actualValue,
        });
      };


      const handleSubmit = (event) => {
        event.preventDefault();
        console.log(loginDetail);
      

      //submit data to server to generate token
      loginUser(loginDetail).then((data)=>{
        console.log(data.jwtToken);

          //save the data to localstorage
          doLogin(data.jwtToken, () => {
            console.log("login detail is saved to localstorage");
          })
       
  




      }).then(()=>
      toast.success(`Login Successful`, {
        position: "top-right",
        autoClose: 3000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "dark",

        
      })
      
   

      )
      
      
      .catch(error =>{
        console.log(error)
      })
      
    }
  return (
    <>

  <div className='cont'>
 <div class="login-box">
        <div class="login-header">
            <header>Login</header>
        </div>
        <div class="input-box">
            <input type="email" class="input-field" placeholder="Email" autocomplete="off" value={loginDetail.emailId}  
     onChange={(e) => handleChange(e, "emailId")} required/>
        </div>
        <div class="input-box">
            <input type="password" class="input-field" placeholder="Password" autocomplete="off" value={loginDetail.password}
         onChange={(e) => handleChange(e, "password")} required/>
        </div>
        <div class="forgot">
            <section>
                <input type="checkbox" id="check"/>
                <label for="check">Remember me</label>
            </section>
            <section>
                <a href="#">Forgot password</a>
            </section>
        </div>
        <div class="input-submit">
            <button class="submit-btn" id="submit" onClick={handleSubmit}></button>
            <label for="submit">Sign In</label>
        </div>
        <div class="sign-up-link">
            <p>Don't have account? <a href="/register">Sign Up</a></p>
        </div>
    </div>
</div>



         <ToastContainer/>
    </>
  )
}

export default Login