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
              <Link to="/upload" style={{textDecoration: "none"}} >
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Upload de Arquivo
                </Button>
              </Link>
              <Link to="/chamados/dashboard" style={{textDecoration: "none"}}>
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Chamados
                </Button>
              </Link>
              <Link to="/recursos/dashboard" style={{textDecoration: "none"}}>
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Recursos
                </Button>
              </Link>
              <Link to="/files/dashboard" style={{textDecoration: "none"}}>
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Arquivos
                </Button>
              </Link>
              <Link to="/graph" style={{textDecoration: "none"}} >
                <Button className={classes.textTitle} variant="text" fullWidth >
                  Gráficos
                </Button>
              </Link>
          </ButtonGroup>
        </ClickAwayListener >
      </Drawer>
  );
}
