import React, { useState } from 'react';
import RecursosGrid from '../RecursosGrid';
import Bar from '../Bar';
import Drawers from '../Drawers';

export default function RecursosDashboard(){
  	const [drawer, setDrawer] = useState(false);
  	const toggleDrawer = (booleanValue) => {
  		setDrawer(booleanValue)
  	}

	return(
		<div>
			<Bar toggleDrawer={toggleDrawer} />
    	<Drawers toggleDrawer={toggleDrawer} open={drawer} />
    	<RecursosGrid />
    </div>
	)

}