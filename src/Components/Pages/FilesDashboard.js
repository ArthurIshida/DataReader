import React, { useState } from 'react';
import FilesGrids from '../FilesGrid';
import Bar from '../Bar';
import Drawers from '../Drawers';

export default function FilesDashboard(){
  	const [drawer, setDrawer] = useState(false);
  	const toggleDrawer = (booleanValue) => {
  		setDrawer(booleanValue)
  	}

	return(
		<div>
			<Bar toggleDrawer={toggleDrawer} />
    		<Drawers toggleDrawer={toggleDrawer} open={drawer} />
    	<FilesGrids />
    </div>
	)

}