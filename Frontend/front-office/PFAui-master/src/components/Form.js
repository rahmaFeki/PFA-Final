import React, { Component } from 'react';
import AccountSetup from './AccountSetup';
import SocialProfiles from './SocialProfiles';
import Confirm from './Confirm';
import Success from './Success';
import axios from 'axios';

export class Form extends Component {
    state = {
        step: 1,
        nom: '',
        lastName: '',
        phone: '',
        gendre: '',
        email: '',
        password: '',
    };
    nextStep = () => {
        const { step } = this.state;
        this.setState({ step: step + 1 });
        console.log(this.state);
    };

    prevStep = () => {
        const { step } = this.state;
        this.setState({ step: step - 1 });
    };

    inputChange = input => e => {
        this.setState({
            [input]: e.target.value
        });
    };

    lastStep = () => {
        const user = {
            nom: this.state.nom,
            prenom: this.state.lastName,
            tel: this.state.phone,
            cin: this.state.cin,
            genre: this.state.gendre,
            email: this.state.email,
            password: this.state.password
          };
          let body= JSON.stringify(user)
          console.log(body);
          axios.post("http://localhost:8009/api/appprenat", body, {headers: {'Content-Type': 'application/json'} })
            .then(res => {
              console.log(res);
              console.log(res.data);
            })
    };

    render() {
        const { step } = this.state;
        const { nom, lastName, phone, cin, gendre, email, password } = this.state;
        const values = { nom, lastName, phone, cin, gendre, email, password };

        switch (step) {            
          case 1:
                return (
                    <AccountSetup
                        nextStep={this.nextStep}
                        inputChange={this.inputChange}
                        values={values}
                    />
                );  
            case 2:
                return (
                    <SocialProfiles
                        nextStep={this.nextStep}
                        prevStep={this.prevStep}
                        inputChange={this.inputChange}
                        values={values}
                    />
                );
            case 3:
                return (
                    <Confirm
                        nextStep={this.nextStep}
                        prevStep={this.lastStep}
                        values={values}
                    />
                );
            case 4:
                return (
                    <Success />
                );
        }
    }
}

export default Form
