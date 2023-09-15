import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';
import { useNavigate,useParams } from 'react-router-dom';
import Swal from 'sweetalert2';
import { payment } from '../Checkout/Checkout';
import { useLocation } from 'react-router-dom';
function DForm() {
  const [validated, setValidated] = useState(false);
  const navi = useNavigate();
  const location=useLocation();
  console.log(location)
  // const {props.cities.id}=useParams();
  const[price,setPrice] = useState(location.state);

  const handlePayment=async (e)=>{
    console.log(e)
    await payment(e);
    
  }

  const handleSubmit = (event) => {
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      // event.preventDefault();
      event.stopPropagation();
    }
    
    else{
    // Swal.fire("Congrats", "Booked successfully", "success");
    
    navi("/holidays");
    }
    setValidated(true);
    

  };

  return (
    <div style={{marginLeft:"5px", marginRight:"5px"}}>
    <Form noValidate validated={validated} onSubmit={handleSubmit}>
      <Row className="mb-4">
        <Form.Group as={Col} md="4" mx="3" controlId="validationCustom01">
          <Form.Label >First name</Form.Label>
          <Form.Control
            required
            type="text"
            placeholder="First name"
            defaultValue="Mark"
          />
          <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
        </Form.Group>
        <Form.Group as={Col} md="4" controlId="validationCustom02">
          <Form.Label>Last name</Form.Label>
          <Form.Control
            required
            type="text"
            placeholder="Last name"
            defaultValue="Otto"
          />
          <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
        </Form.Group>
        <Form.Group as={Col} md="4" controlId="validationCustomUsername">
          <Form.Label>Email</Form.Label>
          <InputGroup hasValidation>
            {/* <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text> */}
            <Form.Control
              type="email"
              placeholder="Email"
              aria-describedby="inputGroupPrepend"
              required
            />
            <Form.Control.Feedback type="invalid">
              Please enter email.
            </Form.Control.Feedback>
          </InputGroup>
        </Form.Group>
      </Row>
      <Row className="mb-3">
        <Form.Group as={Col} md="6" controlId="validationCustom03">
          <Form.Label>City</Form.Label>
          <Form.Control type="text" placeholder="City" required />
          <Form.Control.Feedback type="invalid">
            Please provide a valid city.
          </Form.Control.Feedback>
        </Form.Group>
        <Form.Group as={Col} md="3" controlId="validationCustom04">
          <Form.Label>State</Form.Label>
          {/* <Form.Control type="text" placeholder="State" required /> */}
          <Form.Select defaultValue="Choose..." required>
  <option></option>
  <option>Maharashtra</option>
  <option>Karnataka</option>
  <option>Delhi</option>
  <option>Uttar Pradesh</option>
  <option>Andhra Pradesh</option>
  <option>Bihar</option>
  </Form.Select>
        </Form.Group>
        <Form.Group as={Col} md="3" controlId="validationCustom05">
          <Form.Label>Zip</Form.Label>
          <Form.Control type="text" placeholder="Zip" required />
          <Form.Control.Feedback type="invalid">
            Please provide a valid zip.
          </Form.Control.Feedback>
        </Form.Group>
      </Row>
      <Form.Group className="mb-3">
        <Form.Check
          required
          label="Agree to terms and conditions"
          feedback="You must agree before submitting."
          feedbackType="invalid"
        />
      </Form.Group>
      
      <Button type="submit" style={{marginLeft:"45%"}} onClick={()=>{handlePayment(price)}}>Submit form and Pay</Button>
    </Form>
    </div>
    
  );
}

export default DForm;







{/* <Form.Group as={Col} controlId="formGridState">
<Form.Label>State</Form.Label>
<Form.Select defaultValue="Choose...">
  <option>Choose State</option>
  <option>Maharashtra</option>
  <option>Karnataka</option>
  <option>Delhi</option>
  <option>Uttar Pradesh</option>
  <option>Andhra Pradesh</option>
  <option>Bihar</option>




</Form.Select>
</Form.Group> */}