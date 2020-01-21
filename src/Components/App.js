import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Bar from './Bar';
import Drawers from './Drawers';
import GraphPage from './Pages/GraphPage';
import ChamadosDashboard from './Pages/ChamadosDashboard';
import FilesDashboard from './Pages/FilesDashboard';
import UploadPage from './Pages/UploadPage';
import HomePage from './Pages/HomePage';

export default function App(){
  	const [drawer, setDrawer] = useState(false);
  	const toggleDrawer = (booleanValue) => {
  		setDrawer(booleanValue)
  	}
	// eslint-disable-next-line
	const Options = 
		<div>
			<Bar toggleDrawer={toggleDrawer} />
      		<Drawers toggleDrawer={toggleDrawer} open={drawer} />
      	</div>

	return(
		<Router>
			<Switch>
				<Route exact path='/chamados/dash' component={ChamadosDashboard} />
				<Route exact path='/files/dash' component={FilesDashboard} />
				<Route exact path='/' component={HomePage} />
				<Route exact path='/upload' component={UploadPage} />
				<Route exact path='/graph' component={GraphPage} />
			</Switch>
		</Router>
	)
}
