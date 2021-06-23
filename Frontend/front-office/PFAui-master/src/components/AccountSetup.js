import React, { Component } from 'react'

export class AccountSetup extends Component {
    continue = e => {
        e.preventDefault();
        this.props.nextStep();
    };


    render() {
        const { values, inputChange } = this.props;

        return (
            <div className="form-container">
                <h1 className="mb-4">Coordonnées personnelles</h1>
                <div className="form-group">
                    <label htmlFor="firstName">First name</label>
                    <input type="text" className="form-control" name="nom" onChange={inputChange('nom')} value={values.nom} />
                </div>
                <div className="form-group">
                    <label htmlFor="lastName">Last name</label>
                    <input type="text" className="form-control" name="prenom" onChange={inputChange('lastName')} value={values.lastName} />
                </div>
                <div className="form-group">
                    <label htmlFor="phone">Phone Number</label>
                    <input type="text" className="form-control" name="phone" onChange={inputChange('phone')} value={values.phone} />
                </div>
                <div className="form-group">
                    <label htmlFor="cin">CIN</label>
                    <input type="text" className="form-control" name="cin" onChange={inputChange('cin')} value={values.cin} />
                </div>

                <div onChange={inputChange('gendre')} value={values.gendre}>
                    <label htmlFor="gendre">Gendre</label> <br />
                    <input type="radio" value="Male" name="gender" /> Male <br />
                    <input type="radio" value="Female" name="gender" /> Female
                </div>

                 <div className="text-right">
                    <button className="btn btn-warning" onClick={this.continue}>Continue</button>
                </div>
            </div>
        )
    }
}

export default AccountSetup
