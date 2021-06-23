import React, { Component } from 'react'

export class Confirm extends Component {
    confirm = e => {
        e.preventDefault();
        this.props.prevStep();
    };

    back = e => {
        e.preventDefault();
        this.props.prevStep();
    };

    render() {
        const {
            values: { nom, lastName, phone, cin, gendre, email, password }
        } = this.props;

        return (
            <div className="form-container">
                <h1 className="mb-5">Confirm</h1>
                <ul class="list-group">
                    <li class="list-group-item">First Name: {nom}</li>
                    <li class="list-group-item">Last Name: {lastName}</li>
                    <li class="list-group-item">Email: {email}</li>
                    <li class="list-group-item">Phone Number: {phone}</li>
                    <li class="list-group-item">CIN: {cin}</li>
                </ul>

                <br /><br />

                <div className="row">
                    <div className="col-6">
                        <button className="btn btn-warning" onClick={this.back}>Back</button>
                    </div>
                    <div className="col-6 text-right">
                        <button className="btn btn-warning" onClick={this.confirm}>Confirm</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default Confirm
