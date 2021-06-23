import React, {  useState } from "react";
import { Modal,Button } from 'react-bootstrap';
import Loginform from '../components/Loginform';
import { NavLink } from 'react-router-dom';

function Navbar() {
    const [show, setShow] = useState(false);
    
    const [msgError, setMsgError] = useState('');
    const handleClose = () => setShow(false);
    function handleShow (){
        setMsgError('');
        setShow(true);
      }
      

  return (
    <div className="navigation">
    <div className="container">
        <div className="row">
            <div className="col-lg-10 col-md-10 col-sm-9 col-8">
                <nav className="navbar navbar-expand-lg">
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="icon-bar"></span>
                        <span className="icon-bar"></span>
                        <span className="icon-bar"></span>
                    </button>

                    <div className="collapse navbar-collapse sub-menu-bar" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <NavLink to="/"><i className="nav-item">Home</i></NavLink>
                            </li>
                            
                                  
    
                            <li> <NavLink to="/courses"><i className="nav-item">Courses</i></NavLink></li>
                        </ul>
                    </div>
                </nav>
            </div>
            <div className="col-lg-2 col-md-2 col-sm-3 col-4">
                <div className="right-icon text-right">
                    <ul>
                        <li><a href="#" id="search"><i className="fa fa-search"></i></a></li>
                        <li><a href="#"><i className="fa fa-user-circle-o " ></i></a></li>

                                

                    </ul>
                </div> 
            </div>
        </div> 
    </div> 
</div>      
  );
}

export default Navbar;