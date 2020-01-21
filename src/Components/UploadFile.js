import React from 'react';
import { Grid, Button, Typography } from '@material-ui/core';
import { useDropzone } from 'react-dropzone';
import { withRouter } from 'react-router-dom';
import { useStyles } from './Styles';


export default withRouter(function UploadFile(props){
	var file = {};
	const classes = useStyles();
	const {acceptedFiles, getRootProps, getInputProps} = useDropzone({
		accept: '.csv'
	});

	const acceptedFilesItems = acceptedFiles.map(file => (
		<li key={file.path}>
			{file.path} - {file.size} bytes
		</li>
  	));


	const onFileChangeHandler = () => {
		file = acceptedFiles;
		console.log("File Data: " + file);
		if(file !== undefined || file !== null){
		    var formData = new FormData();
			formData.append('files', file[0], file[0].name)
	        formData.append('key', 'files')
		    console.log("Form Data: " + formData.get('files'))
		    fetch('/api/files/upload', {
		        method: 'POST',
		        body: formData
		    }).then(res => {
		        if(res.ok) {
		            console.log("Res Data: " + res.data);
		            console.log("File uploaded successfully.");
		        }
		    });
		}
	};

    return(
    	<Grid container direction="column" className={classes.paper} >
			<Grid {...getRootProps({className: 'dropzone'})}>
				<div className={classes.dropzoneStyle}>
					<input multiple {...getInputProps()} />
					<h4 className={classes.textTitle}>Selecione seus arquivos ou arraste-os</h4>
				</div>
			</Grid>
			<aside>
			<Typography className={classes.textTitle}>
				<h4>Accepted files</h4>
		        <ul>
		          {acceptedFilesItems}
		        </ul>
		    </Typography>
			</aside>
			<Button onClick={onFileChangeHandler} >
				<Typography className={classes.textTitle}>
					Upload
				</Typography>
			</Button>
		</Grid>
    )
})