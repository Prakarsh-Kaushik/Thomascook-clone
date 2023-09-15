import React from 'react'
import "./Offers.css"
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
const Offers = () => {
  return (
  <>
  <div>
    <img src="https://www.thomascook.in/images/site-banners/offer_and_deals.webp" className='imgSize'/>
  </div>
  <div>
    {/* <br/> */}
    <br/>
  <h2 className="offer-head">All Offers and Deals</h2>
  
  <div class="container" style={{marginLeft:"90px",marginTop:"20px"}}>
    <div class="row gy-3">
        <div class="col-sm">
            <div class="card h-100">
                <img src="https://www.thomascook.in/images/offers/icici-intlhol.jpg" class="card-img-top" alt="..."/>
                <div class="card-body">
                  <h5 class="card-title">10% up to Rs. 2,000*</h5>
                  <p class="card-text">Book International Holidays with ICICI    <br/>Expires on 31st December 2024</p>
                </div>
              </div>
        </div>
        <div class="col-sm">
            <div class="card h-100">
                <img src="https://www.thomascook.in/images/offers/sbi-intlhol.jpg" class="card-img-top" alt="..."/>
                <div class="card-body">
                  <h5 class="card-title">FLAT Rs.550 OFF* </h5>
                  <p class="card-text"> Book India Holidays with SBI<br/>Expires on 31st December 2024</p>
                </div>
              </div>
        </div>
        <div class="col-sm">
            <div class="card h-100">
                <img src="https://www.thomascook.in/images/offers/axis-intlhol.jpg" class="card-img-top" alt="..."/>
                <div class="card-body">
                  <h5 class="card-title">10% discount up to Rs. 4,000*</h5>
                  <p class="card-text">Book Hotels with Axis Bank.<br/>Expries on 31st December 2024</p>
                </div>
              </div>
        </div>
        <div class="col-sm">
            <div class="card h-100">
                <img src="https://www.thomascook.in/images/offers/kotak-intlhol.jpg" class="card-img-top" alt="..."/>
                <div class="card-body">
                  <h5 class="card-title">10% discount up to Rs. 3,500*</h5>
                  <p class="card-text">Book Holiday Packages with KMB <br/>Expries on 31st December 2024</p>
                </div>
              </div>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <div></div>
    </div>
</div>


  </div>
  
  </>
  )
}

export default Offers