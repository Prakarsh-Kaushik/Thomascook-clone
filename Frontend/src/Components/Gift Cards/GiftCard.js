import React from 'react'
import "./GiftCard.css"
const GiftCard = () => {
  return (
   <>
   <div>
    <img src="https://www.thomascook.in/images/home-page-banners/2023/may/Gift-Card-LP-Banner-1920x550.webp" className='giftImg'/>
   </div>
    <div className='giftContent'>
    Gifting is so much more than exchange of tangible objects - it is one of the most beautiful ways to express your love, care and affection. Choosing a gift of travel is more like doing something out of ordinary for people who have always made you feel special.


    </div>
    <div className='gift-head'>
    Gift Card by Occasion
    </div>


    <div class="container" style={{marginLeft:"90px",marginTop:"20px"}}>
    <div class="row gy-3">
        <div class="col-sm">
            <div class="card h-50">
                <img src="https://www.thomascook.in/images/giftcard/occasion-img1.jpg" class="card-img-top" alt="..."/>
                {/* {/* <div class="card-body">
                  <h5 class="card-title">10% up to Rs. 2,000*</h5>
                  <p class="card-text">Book International Holidays with ICICI    <br/>Expires on 31st December 2024</p>
                </div> */}
              </div> 
        </div>
        <div class="col-sm">
            <div class="card h-50">
                <img src="https://www.thomascook.in/images/giftcard/occasion-img2.jpg" class="card-img-top" alt="..."/>
                {/* {/* <div class="card-body">
                  <h5 class="card-title">10% up to Rs. 2,000*</h5>
                  <p class="card-text">Book International Holidays with ICICI    <br/>Expires on 31st December 2024</p>
                </div> */}
              </div> 
        </div>
        <div class="col-sm">
            <div class="card h-50">
                <img src="https://www.thomascook.in/images/giftcard/occasion-img3.jpg" class="card-img-top" alt="..."/>
                {/* {/* <div class="card-body">
                  <h5 class="card-title">10% up to Rs. 2,000*</h5>
                  <p class="card-text">Book International Holidays with ICICI    <br/>Expires on 31st December 2024</p>
                </div> */}
              </div> 
        </div>
        <div class="col-sm">
            <div class="card h-50">
                <img src="https://www.thomascook.in/images/giftcard/occasion-img4.jpg" class="card-img-top" alt="..."/>
                {/* {/* <div class="card-body">
                  <h5 class="card-title">10% up to Rs. 2,000*</h5>
                  <p class="card-text">Book International Holidays with ICICI    <br/>Expires on 31st December 2024</p>
                </div> */}
              </div> 
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div className='gift-head'>
        How to Redeem Gift card
        </div>
        <div className='RedeemCard'>
          <div className='RedeemHead'>Select Product
          <div className='RedeemContent'>
          Select Flight/ Hotel/ Holidays and <br/>proceed towards payment
          </div>
          </div>
          <div className='RedeemHead'>Payment Mode
          <div className='RedeemContent'>
          Select Gift Card as a payment <br/>mode
          </div>
          </div>
          <div className='RedeemHead' >Gift Card details
          <div className='RedeemContent'>
          Enter the 16 digit Gift Card number<br/> and 6 digit pin to validate your card
          </div>
          </div>
          <div className='RedeemHead'>Confirmation
          <div className='RedeemContent'>
          Click on Book Now or select <br/>another payment mode in case of<br/> balance payment
          </div>
          </div>
        </div>
        <br/>
        <br/>
    </div>
</div>



    </>
  )
}

export default GiftCard