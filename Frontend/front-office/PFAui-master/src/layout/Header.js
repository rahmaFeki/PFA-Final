import React, {  useState } from "react";
import { Modal,Button } from 'react-bootstrap';
import Form from '../components/Form';
import Loginform from '../components/Loginform';


function Header() {
    const [show, setShow] = useState(false);
    const [showTwo, setShowTwo] = useState(false);
    
    const [msgError, setMsgError] = useState('');
    const handleClose = () => setShow(false);
    const handleCloseTwo = () => setShowTwo(false);

    function handleShow (){
        setMsgError('');
        setShow(true);
      }
      function handleShowTwo (){
        setMsgError('');
        setShowTwo(true);
      }  

      function handleShowConnect (){
        setMsgError('');
        setShow(false);
        setShowTwo(true);
      }  

    return (
        <div id="header-part">
        
            <div className="header-top d-none d-lg-block">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-6">
                            <div className="header-contact text-lg-left text-center">
                                <ul>
                                    <li><img src="/assets/images/all-icon/map.png" alt="icon" /><span>km 4 Route de la Soukra, Sfax 3038</span></li>
                                    <li><img src="/assets/images/all-icon/email.png" alt="icon" /><span>info@enis.tn</span></li>
                                </ul>
                            </div>
                        </div>
                        <div className="col-lg-6">
                            <div className="header-opening-time text-lg-right text-center">
                                <p>Opening Hours : Monday to Saturay - 8 Am to 5 Pm</p>
                            </div>
                        </div>
                    </div>
                </div> 
            </div> 
            
            <div className="header-logo-support pt-30 pb-30">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-4 col-md-4">
                            <div className="logo">
                                <a href="index-2.html">
                                    <img src="/assets/images/logo.png" alt="Logo" />
                                </a>
                            </div>
                        </div>
                        <div className="col-lg-8 col-md-8">
                            <div className="support-button float-right d-none d-md-block">
                                <div className="support float-left">
                                    <div className="icon">
                                        <img src="/assets/images/all-icon/support.png" alt="icon" />
                                    </div>
                                    <div className="cont">
                                        <p>Need Help? call us free</p>
                                        <span>321 325 678</span>
                                    </div>
                                </div>
                                <div className="button float-left">
                                        <button type="button" className="btn btn-warning" onClick={handleShow}>Sign up</button>
                                            <Modal show={show} onHide={handleClose}>
                                                <Modal.Body>
                                                    <Form />
                                                    <div className="text-left">        
                                                            <p >Do you have an account?</p><button className="btn btn-outline-secondary" onClick={handleShowConnect}>Connect</button>
                                                    </div>                                                
                                                </Modal.Body>    
                                            </Modal>
                                            <Modal show={showTwo} onHide={handleCloseTwo}>
                                                        <Modal.Body>
                                                            <Loginform />
                                                        </Modal.Body>        
                                                    </Modal> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            

            
        </div>
    );
}

export default Header;