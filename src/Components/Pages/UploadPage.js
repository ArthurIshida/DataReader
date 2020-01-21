import React, { useState } from 'react';
import Bar from '../Bar';
import Drawers from '../Drawers';
import UploadFile from '../UploadFile';

export default function UploadPage(){
  	const [drawer, setDrawer] = useState(false);
  	const toggleDrawer = (booleanValue) => {
  		setDrawer(booleanValue)
  	}

	return(
		<div>
			<Bar toggleDrawer={toggleDrawer} />
	    	<Drawers toggleDrawer={toggleDrawer} open={drawer} />
	    	<UploadFile />
		</div>
	)
}