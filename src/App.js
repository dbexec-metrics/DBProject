import React, { Component } from "react";
import Navbar from "./navbar";
import "./App.css";
import userlogo from "./user.png";
import TextField from "@material-ui/core/TextField";
import "bootstrap/dist/css/bootstrap.min.css";
import { makeStyles } from "@material-ui/core/styles";
import { InputAdornment, withStyles } from "@material-ui/core";
import background from "./abc.jpg";
import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const styles = theme => ({
    multilineColor: {
        color: "white"
    }
});
var sectionStyle = {
  backgroundImage: "url(" + background + ")"
};
const StyledButton = withStyles({
    root: {
        "& .MuiOutlinedInput-root .MuiOutlinedInput-notchedOutline": {
            borderWidth: "2px",
            borderRadius: "20px",
            borderColor: "white"
        },
        "&:hover .MuiOutlinedInput-root .MuiOutlinedInput-notchedOutline": {
            borderWidth: "2px",
            borderRadius: "20px",
            borderColor: "red"
        },
        "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
            borderWidth: "2px",
            borderRadius: "20px",
            borderColor: "green"
        }
    }
})(TextField);

const StyledButton1 = withStyles({
    root: {
        "& .MuiOutlinedInput-root .MuiOutlinedInput-notchedOutline": {
            borderWidth: "2px",
            borderRadius: "20px",
            borderColor: "white"
        },
        "&:hover .MuiOutlinedInput-root .MuiOutlinedInput-notchedOutline": {
            borderWidth: "2px",
            borderRadius: "20px",
            borderColor: "red"
        },
        "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
            borderWidth: "2px",
            borderRadius: "20px",
            borderColor: "green"
        },
        marginLeft: "145px"
    }
})(TextField);
toast.configure();
export default class App extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            value: "default",
        };
        this.submit = this.submit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }
    submit(e) {
        e.preventDefault();
        const fo = this.state.value;
        console.log(fo);

        axios.post(
            "http://localhost:8080/submitQuery",
            fo
        ).then(res => {
                console.log(res);
        }).catch(err => {
                console.log(err);
        })
        
    }
    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    onChange = event => {
        const { name, value } = event.target;

        this.setState({ [name]: value });
    };
    render() {
        const { classes } = this.props;

        return (
            <React.Fragment>
                <img src={background} className="main"/>
                <div className="main">
                    <Navbar></Navbar>
                    <title>SPARK SQL TOOL</title>
                    <link rel="stylesheet" type="text/css" href="App.css" />
                    <div className="companybox">
                        <form onSubmit={this.submit} >
                            <p style={{
                                color: 'white', fontFamily: 'Times New Roman', fontSize: '27px' }}>SPARK EXECUTION PLANS VIEWER</p>
                            <br></br>
                            <br></br>
                            <textarea
                                name="Title"
                                type="textarea"
                                borderRadius="5px"
                                name="address"
                                placeholder="ENTER SPARK SQL QUERY"
                                id="oo"
                                required
                                onChange={this.handleChange}
                            />
                            <br></br>
                            <br></br>
                            <br></br>
                            <button class="button button1" >SUBMIT</button>
                            <br></br>
                        </form>
                    </div>
                </div>
            </React.Fragment>
        );
    }
}
App = withStyles(styles)(App);
