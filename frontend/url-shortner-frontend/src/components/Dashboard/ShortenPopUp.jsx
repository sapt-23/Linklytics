
import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import CreateNewShorten from './CreateNewShorten';

const ShortenPopUp = ({open,setOpen,refetch}) => {
    const handleClose = () => setOpen(false);
  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <div className='flex justify-center items-center h-full w-full'>
            <CreateNewShorten refetch={refetch} setOpen={setOpen} />
        </div>
        {/* <Box >
          <Typography id="modal-modal-title" variant="h6" component="h2">
            Text in a modal
          </Typography>
          <Typography id="modal-modal-description" sx={{ mt: 2 }}>
            Duis mollis, est non commodo luctus, nisi erat porttitor ligula.
          </Typography>
        </Box> */}
      </Modal>
    </div>
  )
}

export default ShortenPopUp

