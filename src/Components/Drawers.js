import React from 'react';
import { Drawer, ClickAwayListener, IconButton, Divider, Button, ButtonGroup } from '@material-ui/core';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import { Link } from 'react-router-dom';
import { useStyles } from './Styles';

export default function Drawers(props) {
  const classes = useStyles();

  return(
      <Drawer variant="temporary" anchor="left" open={props.open} >
        <div className={classes.drawerHeader} >
          <IconButton onClick={() => props.toggleDrawer(false)} >
            <ChevronLeftIcon />
          </IconButton>
        </div>
        <Divider />

        <ClickAwayListener onClickAway={() => props.toggleDrawer(false)} >
          <ButtonGroup className={classes.buttonGroup}>
              <Link to="/chamados/dash" style={{textDecoration: "none"}}>
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Chamado Dashboard
                </Button>
              </Link>
              <Link to="/files/dash" style={{textDecoration: "none"}}>
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Files Dashboard
                </Button>
              </Link>
              <Link to="/upload" style={{textDecoration: "none"}} >
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Upload File
                </Button>
              </Link>
              <Link to="/graph" style={{textDecoration: "none"}} >
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Graphics
                </Button>
              </Link>
          </ButtonGroup>
        </ClickAwayListener >
      </Drawer>
  );
}
