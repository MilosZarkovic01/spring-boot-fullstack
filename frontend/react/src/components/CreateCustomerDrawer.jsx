import {
    Button,
    Drawer,
    DrawerBody,
    DrawerCloseButton,
    DrawerContent,
    DrawerFooter,
    DrawerHeader,
    DrawerOverlay,
    useDisclosure
} from "@chakra-ui/react";
import * as PropTypes from "prop-types";
import CreateCustomerForm from "./CreateCustomerForm.jsx";

const AddIcon = () => '+';
const CloseIcon = () => 'x';

DrawerBody.propTypes = {children: PropTypes.node};
export const CreateCustomerDrawer = ({fetchCustomers}) => {
    const {isOpen, onOpen, onClose} = useDisclosure()

    return <>
        <Button
            leftIcon={<AddIcon/>}
            onClick={onOpen}
            colorScheme={'teal'}
        >
            Create customer
        </Button>
        <Drawer isOpen={isOpen} onClose={onClose} size={"lg"}>
            <DrawerOverlay/>
            <DrawerContent>
                <DrawerCloseButton/>
                <DrawerHeader>Create new customer</DrawerHeader>

                <DrawerBody>
                    <CreateCustomerForm
                        fetchCustomers={fetchCustomers}
                    />
                </DrawerBody>

                <DrawerFooter>
                    <Button
                        leftIcon={<CloseIcon/>}
                        onClick={onClose}
                        colorScheme={'teal'}
                    >
                        Close
                    </Button>
                </DrawerFooter>
            </DrawerContent>
        </Drawer>
    </>
}


