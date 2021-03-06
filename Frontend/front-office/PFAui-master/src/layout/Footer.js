import React from 'react';
function Footer() {
  return (
    <div id="footer-part">
        <div className="footer-top pt-40 pb-70">
            <div className="container">
                <div className="row">
                    <div className="col-lg-4 col-md-6">
                        <div className="footer-about mt-40">
                            <div className="logo">
                                <a href="#"><img src="/assets/images/logo-2.png" alt="Logo" /></a>
                            </div>
                            <p>EDUNBIN in the best skills center wher you can boost your knowledge in various fields.</p>
                            <ul className="mt-20">
                                <li><a href="#"><i className="fa fa-facebook-f"></i></a></li>
                                <li><a href="#"><i className="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i className="fa fa-google-plus"></i></a></li>
                                <li><a href="#"><i className="fa fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-lg-3 col-md-6 col-sm-6">
                        <div className="footer-link mt-40">
                            <div className="footer-title pb-25">
                                <h6>Sitemap</h6>
                            </div>
                            <ul>
                                <li><a href="index-2.html"><i className="fa fa-angle-right"></i>Home</a></li>
                                <li><a href="courses.html"><i className="fa fa-angle-right"></i>Courses</a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-lg-2 col-md-6 col-sm-6">
                        <div className="footer-link support mt-40">
                            <div className="footer-title pb-25">
                                <h6>Support</h6>
                            </div>
                            <ul>
                                <li><a href="#"><i className="fa fa-angle-right"></i>FAQS</a></li>
                                <li><a href="#"><i className="fa fa-angle-right"></i>Privacy</a></li>
                                <li><a href="#"><i className="fa fa-angle-right"></i>Policy</a></li>
                                <li><a href="#"><i className="fa fa-angle-right"></i>Support</a></li>
                                <li><a href="#"><i className="fa fa-angle-right"></i>Documentation</a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-lg-3 col-md-6">
                        <div className="footer-address mt-40">
                            <div className="footer-title pb-25">
                                <h6>Contact Us</h6>
                            </div>
                            <ul>
                                <li>
                                    <div className="icon">
                                        <i className="fa fa-home"></i>
                                    </div>
                                    <div className="cont">
                                        <p>km 4 Route de la Soukra, Sfax 3038</p>
                                    </div>
                                </li>
                                <li>
                                    <div className="icon">
                                        <i className="fa fa-phone"></i>
                                    </div>
                                    <div className="cont">
                                        <p>23 456 789</p>
                                    </div>
                                </li>
                                <li>
                                    <div className="icon">
                                        <i className="fa fa-envelope-o"></i>
                                    </div>
                                    <div className="cont">
                                        <p>info@enis.tn</p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    );
}

export default Footer;    
