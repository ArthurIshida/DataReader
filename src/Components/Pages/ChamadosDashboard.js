import React, { useState } from 'react';
import ChamadosGrids from '../ChamadosGrid';
import Bar from '../Bar';
import Drawers from '../Drawers';

export default function ChamadosDashboard(){
  	const [drawer, setDrawer] = useState(false);
  	const toggleDrawer = (booleanValue) => {
  		setDrawer(booleanValue)
  	}

	return(
		<div>
			<Bar toggleDrawer={toggleDrawer} />
    	<Drawers toggleDrawer={toggleDrawer} open={drawer} />
    	<ChamadosGrids />
    </div>
	)

}