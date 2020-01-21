/* eslint-disable no-script-url */
import React from 'react';
import { AppBar, Toolbar, IconButton } from '@material-ui/core';
import MenuIcon from '@material-ui/icons/Menu';
import HomeIcon from '@material-ui/icons/Home';
import { Link } from 'react-router-dom';
import { useStyles } from './Styles';

export default function Bar(props){
  // eslint-disable-next-line
  const classes = useStyles();

  return(
      <div>
        <AppBar position="sticky" style={{backgroundColor: "white"}}>
          <Toolbar>
            <IconButton onClick={() => {props.toggleDrawer(true)}} edge="start" >
              <MenuIcon />
            </IconButton>
            <Link to="/">
              <img src="union-digital-logo-p.png" alt="Union Digital" />
            </Link>
            <Link to="/" className={classes.homeIcon}>
              <IconButton >
                <HomeIcon />
              </IconButton>
            </Link>
           </Toolbar>
        </AppBar>
      </div>
  )
}
