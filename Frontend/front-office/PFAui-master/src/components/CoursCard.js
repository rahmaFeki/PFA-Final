import React, { Component } from 'react';
import { Card,Modal } from 'react-bootstrap';
import { CardDeck } from 'react-bootstrap';
import {Fragment} from 'react';
import FormationService from '../sevices/FormationService';
import Pagination from '../components/Pagination';
import axios from 'axios';
import Swal from 'sweetalert2';
import StripeCheckout from 'react-stripe-checkout';




export class CoursCard extends Component {
   
       state = {
           formations: [],
           search:"",
           currentFormations: [], 
           currentPage: null, 
           totalPages: null,
           
           
           
       };
       
       
      
   
   componentDidMount(){
       FormationService.getFormation().then(response => response.data ).then((data) => {
        this.setState({ formations: data });
        console.log(this.state.formations);
       })
      
   }
   onchange = e =>{
       this.setState({ search : e.target.value});
   }
   onPageChanged = data => {
    const { formations } = this.state;
    const { currentPage, totalPages, pageLimit } = data;
    const offset = (currentPage - 1) * pageLimit;
    const currentFormations = formations.slice(offset, offset + pageLimit);

    this.setState({ currentPage, currentFormations, totalPages });
  }
  
  
  onToken = (token, addresses) => {
    // TODO: Send the token information and any other
    // relevant information to your payment process
    // server, wait for the response, and update the UI
    // accordingly. How this is done is up to you. Using
    // XHR, fetch, or a GraphQL mutation is typical.
    console.log({token,addresses})
    const amount=this.state.formations.prix;
    
    axios
    .post("http://localhost:8009/payment", {
      
      token,
    })
    .then((response) => {
      console.log(response);
      Swal.fire({
        position: 'top-end',
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
        const {search} = this.state;
          const filtredFormations = this.state.formations.filter(formation =>{
              return formation.nom.toLowerCase().indexOf( search.toLowerCase())!= -1
          })
          const { formations, currentFormations, currentPage, totalPages } = this.state;
          const totalformations = filtredFormations.length;
          if (totalformations === 0) return null;
          const headerClass = ['text-dark py-2 pr-4 m-0', currentPage ? 'border-gray border-right' : ''].join(' ').trim();
        return (
            
            <Fragment>
                
            <div>
                <section id="page-banner" className="pt-105 pb-110 bg_cover" data-overlay={8} style={{backgroundImage: 'url(../assets/images/page-banner-2.jpg)'}}>
                    <div className="container">
                        <div className="row">
                        <div className="col-lg-12">
                            <div className="page-banner-cont">
                            <h2>Our Courses</h2>
                            <nav aria-label="breadcrumb">
                                <ol className="breadcrumb">
                                <li className="breadcrumb-item"><a href="#">Home</a></li>
                                <li className="breadcrumb-item active" aria-current="page">Courses</li>
                                </ol>
                            </nav>
                            </div>  {/* page banner cont */}
                        </div>
                        </div> {/* row */}
                    </div> {/* container */}
                </section>
          </div>
          
          <div>
                <input type="text" class="form-control" placeholder="Search" onChange={this.onchange} />
          </div>
           <div>
           <h2 className={headerClass}>
                {totalformations} Formations
              </h2>
              { currentPage && (
                <span className="current-page d-inline-block h-100 pl-4 text-secondary">
                  Page <span className="font-weight-bold">{ currentPage }</span> / <span className="font-weight-bold">{ totalPages }</span>
                </span>
              ) }
          </div>         
          
          <div style={{ marginTop: '5em',marginBottom: '5em'}}>
          <div className="d-flex flex-row py-4 align-items-center">
              <Pagination totalRecords={totalformations} pageLimit={18} pageNeighbours={1} onPageChanged={this.onPageChanged} />
            </div>
          <CardDeck style={{display: 'flex', flexDirection: 'row' , justifyContent: 'center',gap: '2em'}}>
            
          {filtredFormations.map((formations) => (
              
                    <Card style={{minWidth:'25em',maxWidth:'25em',flex: '1'}} key={formations.id_formation}>
                    <React.Fragment>
                    <div className="thum" width="2%" height="20%">  
                        <Card.Img className="image" variant="top" src={"data:image/jpeg;base64,"+formations.img} width="10%" height="%"/>
                    </div>
                        <Card.Body>
                        <Card.Title className="name">{formations.nom}</Card.Title>
                        <Card.Text className="price">price:{formations.prix}dt</Card.Text>
                        </Card.Body>
                        
                        
                        <StripeCheckout label="Enroll Now" 
        stripeKey="pk_test_51Iz1kQLonKgeU8jRVxSDW5Ftosa8rMgw8bgKYlnJRukZCqMvF3L8W1T9tj9zR72eQ8mJ3VeS48JybpJlWYZjT3zc00z92gbFYc"
        token={this.onToken}
        amount={formations.prix* 100}
      />
                        
                    </React.Fragment>
                    
                    </Card>
            ))}
            </CardDeck>
            </div>
            </Fragment>      );
            
          
         
           
        
       
    }
}

export default CoursCard;
