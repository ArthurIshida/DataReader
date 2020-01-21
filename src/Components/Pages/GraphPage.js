import React, { useState } from 'react';
import Bar from '../Bar';
import Drawers from '../Drawers';
import Graph from '../Graph';

export default function GraphPage(){
  	const [drawer, setDrawer] = useState(false);
  	const toggleDrawer = (booleanValue) => {
  		setDrawer(booleanValue)
  	}

	return(
		<div>
			<Bar toggleDrawer={toggleDrawer} />
	    	<Drawers toggleDrawer={toggleDrawer} open={drawer} />
	    	<Graph />
	    </div>
	)
}