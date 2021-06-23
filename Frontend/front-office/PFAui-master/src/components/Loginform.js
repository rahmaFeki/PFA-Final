import React, { Component } from 'react';
import LearnerService from '../sevices/LearnerService'

export class Loginform extends Component{
    constructor(props) {
        super(props);
        this.state = {email: '', password: ''};
      }

         connect = e => {
            e.preventDefault();
            console.log(this.state);

     
                let authentif = {idUser:1,email:this.state.email,password: this.state.password };
             
                LearnerService.login(authentif).then(res => {
                  if(res.data!=""){
                    console.log(res.data)
                    console.log(res.data.email)
                  localStorage.setItem('currentUser', JSON.stringify(res.data)); 
                  }  
                  else {console.log("no user")}
                  
                })
                
        
        
            } 
    render() {        
            return (
                <div className="form-container">
                    <h1 className="mb-5">Sign in</h1>
                    <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input type="email" className="form-control" name="email" value={this.state.email} onChange={e => this.setState({email: e.target.value})} />
                    </div>
                    <br />
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input type="password" className="form-control" name="password" value={this.state.password} onChange={e => this.setState({password: e.target.value})} />
                    </div>

                    <br />


                    <div className="text-right">
                        <button className="btn btn-warning" onClick={this.connect}>connect</button>
                    </div>
                </div>
            )
    }
}


export default Loginform
