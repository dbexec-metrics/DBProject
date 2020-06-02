import React, { Component } from "react";
import styled from "styled-components";
import aabb from "./index.png";
import { fontFamily } from "@material-ui/system";


export default class Navbar extends Component {
  constructor(props) {
    super(props);
    this.state = {
      show: true,
      scrollPos: 0
    };
    this.handleScroll = this.handleScroll.bind(this);
  }

  componentDidMount() {
    window.addEventListener("scroll", this.handleScroll);
  }

  componentWillUnmount() {
    window.removeEventListener("scroll", this.handleScroll);
  }

  handleScroll() {
    const { scrollPos } = this.state;
    this.setState({
      scrollPos: document.body.getBoundingClientRect().top,
      show: document.body.getBoundingClientRect().top > scrollPos
    });
  }

  render() {
    return (
      <Transition>
            <StyledNavbar className={this.state.show ? "active" : "hidden"}>
                <img src={aabb} className="user" />
                {/*<h2 style={{ color: 'white', fontFamily: 'Times New Roman', textAlign: "center" }} align="center">ENTER  SPARK  SQL  QUERY</h2>*/}
        </StyledNavbar>
      </Transition>
    );
  }
}
const Transition = styled.div`
  .active {
    visibility: visible;
    transition: all 200ms ease-in;
  }
  .hidden {
    visibility: hidden;
    transition: all 200ms ease-out;
    transform: translate(0, -100%);
  }
`;
const StyledNavbar = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  padding-left: 1%;
  width: 100%;
  margin: 0 auto;
  height: 3rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  font-weight: bolder;
  font-style: bold;
  fontFamily: "Times New Roman";
  font-size: 20px;
  z-index: 1000;
`;
