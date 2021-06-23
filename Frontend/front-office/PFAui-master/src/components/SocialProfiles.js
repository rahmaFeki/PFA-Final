import React, { Component } from 'react'

export class SocialProfiles extends Component {
    continue = e => {
        e.preventDefault();
        this.props.nextStep();
    };

    back = e => {
        e.preventDefault();
        this.props.prevStep();
    };
    

    render() {
        const { values, inputChange } = this.props;

        return (
            <div className="form-container">
                <h1 className="mb-5">Social Profiles</h1>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input type="email" className="form-control" name="email" onChange={inputChange('email')} value={values.email} />
                </div>
                <br />
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input type="password" className="form-control" name="password" onChange={inputChange('password')} value={values.password} />
                </div>

                <br />

                <div className="row">
                    <div className="col-6">
                        <button className="btn btn-warning" onClick={this.back}>Back</button>
                    </div>
                    <div className="col-6 text-right">
                        <button className="btn btn-warning" onClick={this.continue}>Continue</button>
                        
                    </div>
                </div>
            </div>
        )
    }
}

export default SocialProfiles
