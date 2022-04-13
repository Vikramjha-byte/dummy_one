import React, { Component } from "react";
import "./contact.css"
export class Contact extends Component {
  state = {
    firstName: "",
    lastName: "",
    Email: "",
    Password: "",
    check: false,
    firstNameErr: "",
    lastNameErr: "",
    emailErr: "",
    passwordErr: "",
    checkErr: "",
  };

  handleChange = (e) => {
    const { name, value } = e.target;

    this.setState({
      [name]: value,
    });
  };

  validateTheForm = () => {
    let firstNameErr,
      lastNameErr,
      emailErr,
      passwordErr,
      checkErr = " ";
    if (this.state.firstName.length < 4) {
      firstNameErr = "First name should be more than 4 character.";
    }
    if (this.state.lastName.length < 3) {
      lastNameErr = "Last name should not be empty.";
    }
    if (!this.state.Email.includes("@")) {
      emailErr = "Please enter the valid email.";
    }
    if (this.state.Password.length < 6) {
      passwordErr = "Password must contain 6 characters.";
    }
    if(!this.state.check){
        checkErr="You should agree to terms and conditions."
        // this.setState.check=false;
    }

    if (firstNameErr || lastNameErr || emailErr || passwordErr || checkErr) {
      this.setState({
        firstNameErr,
        lastNameErr,
        emailErr,
        passwordErr,
        checkErr,
      });
    } else {
      this.setState({
        firstNameErr,
        lastNameErr,
        emailErr,
        passwordErr,
        checkErr,
      });
    }
  };

  handlecontact = (e) => {
    e.preventDefault();
    // console.warn("all data",this.name)
    this.validateTheForm();
  };

  render() {
    return (
      <div className="container d-flex flex-column align-items-center">
        <h1 className=" contactTitle text-center border-3 fw-bold border-top border-bottom p-2 m-4 text-uppercase">Contact Us</h1>
        <form className="container mt-4 d-flex flex-column justify-content-center">
          <div className="mb-3">
            <label htmlFor="FirstName" className="form-label">
              First Name
            </label>
            <input
              type="text"
              className="form-control"
              name="firstName"
              id="FirstName"
              onChange={this.handleChange}
              required
            />
          </div>
          <p>{this.state.firstNameErr}</p>
          <div className="mb-3">
            <label htmlFor="LastName" className="form-label">
              Last Name
            </label>
            <input
              type="text"
              className="form-control"
              id="LastName"
              name="lastName"
              required
              onChange={this.handleChange}
            />
          </div>
          <p>{this.state.lastNameErr}</p>
          <div className="mb-3">
            <label htmlFor="Email" className="form-label">
              Email address
            </label>
            <input
              type="email"
              className="form-control"
              id="Email"
              aria-describedby="emailHelp"
              onChange={this.handleChange}
              name="Email"
              required
            />
            <div id="emailHelp" class="form-text">
              We'll never share your email with anyone else.
            </div>
          </div>
          <p>{this.state.emailErr}</p>
          <div className="mb-3">
            <label htmlFor="Password" className="form-label">
              Password
            </label>
            <input
              type="password"
              className="form-control"
              id="Password"
              onChange={this.handleChange}
              name="Password"
              required
            />
          </div>
          <p>{this.state.passwordErr}</p>
          <div className="mb-3 form-check">
            <input
              type="checkbox"
              class="form-check-input"
              id="Check"
              value="unchecked"
              onChange={this.handleChange}
              name="check"
              required
            />
            <label className="form-check-label" htmlFor="Check">
              I agree to terms and condition
            </label>
          </div>
          <p>{this.state.checkErr}</p>
          <button
            type="submit"
            onClick={this.handlecontact}
            className="btn btn-primary text-center"
          >
            Contact me
          </button>
        </form>
      </div>
    );
  }
}

export default Contact;
