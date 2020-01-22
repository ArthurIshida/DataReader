import { makeStyles } from '@material-ui/core'

export const useStyles = makeStyles(theme => ({
  paper: {
    borderRadius: 14,
    width: "100%",
    padding: theme.spacing(3,2),
  },
  textTitle: {
    color: "black",
    fontWeight: "bold",
    fontFamily: "Roboto, sans-serif"
  },
  textField: {
    width: "100%",
    display: "flex",
  },
  drawerHeader: {
    height: 10,
    display: 'flex',
    alignItems: 'center',
    ...theme.mixins.toolbar,
    justifyContent: 'flex-end',
  },
  buttonGroup: {
    display: "flex",
    flexDirection: "column",
    width: 240,
  },
  homeIcon: {
    marginRight: -12,
    marginLeft: "auto"
  },
  inputField: {
    height: 30,
    width: 300,
    border: 0,
    borderBottom: "1px solid black",
    outline: 0,
  },
  dropzoneStyle: {
    flex: 1,
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    padding: '20px',
    borderWidth: 2,
    borderRadius: 2,
    borderColor: '#eeeeee',
    borderStyle: 'dashed',
    backgroundColor: '#fafafa',
    color: '#bdbdbd',
    outline: 'none',
    transition: 'border .24s ease-in-out'
  },
  fabGreen: {
    position: 'absolute',
    bottom: theme.spacing(2),
    right: theme.spacing(2),
    color: theme.palette.common.white,
    backgroundColor: "#FAB240",
    '&:hover': {
      backgroundColor: "#FAB240",
    },
  },
}));