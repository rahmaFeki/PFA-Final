import React from 'react'
import StripeCheckout from 'react-stripe-checkout';
import axios from 'axios';
import Swal from 'sweetalert2';


export default class Checkout extends React.Component {
  onToken = (token, addresses) => {
    // TODO: Send the token information and any other
    // relevant information to your payment process
    // server, wait for the response, and update the UI
    // accordingly. How this is done is up to you. Using
    // XHR, fetch, or a GraphQL mutation is typical.
    console.log({token,addresses})
    axios
    .post("http://localhost:8009/payment", {
      
      token,
    })
    .then((response) => {
      console.log(response);
      Swal.fire({
        position: 'center-start',
        icon: 'success',
        title: 'Your payment has been saved',
        showConfirmButton: false,
        timer: 4000
      })      
    })
    .catch((error) => {
      console.log(error);
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Something went wrong!',
      })
    });
    
  };

  render() {
    return (
      <StripeCheckout label="Enroll Now" data-animation="fadeInUp" data-delay="1.6s" className="main-btn"
        stripeKey="pk_test_51Iz1kQLonKgeU8jRVxSDW5Ftosa8rMgw8bgKYlnJRukZCqMvF3L8W1T9tj9zR72eQ8mJ3VeS48JybpJlWYZjT3zc00z92gbFYc"
        token={this.onToken}
       
      />
    )
  }
}