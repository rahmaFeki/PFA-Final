import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Navbar from './layout/Navbar.js';
import Header from './layout/Header.js';
import Footer from './layout/Footer.js';
import Home from './pages/Home.js';
import Categories from './components/Categories.js';
import CoursCard from './components/CoursCard.js';
import StripeCheckout from './components/StripeCheckout.js';

import './App.css';

function App() {
  return (
    <Router> 
      <div className="App">
        <Header />
        <Navbar />
        <Switch> 
          <Route path = "/"  exact component = {Home} />
          <Route path = "/courses" exact component= {CoursCard}/>
          <Route path = "/stripe"  exact component = {StripeCheckout}/>
        </Switch>
        
        
        <Footer />
      </div>
    </Router> 
  );
}

export default App;
