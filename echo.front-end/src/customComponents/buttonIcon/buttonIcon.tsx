import React from "react";
import './buttonicon.scss'
import { SvgIconComponent } from "@mui/icons-material";

interface button {
    icon: React.ReactElement<SvgIconComponent>;
    label?: string;
    onClick?: () => void;
}

const ButtonIcon : React.FC<button> = ({icon, onClick}) => {
    return (
        <div onClick={onClick} className="bottoneIcon">
            {icon}
        </div>
    )
}

export default ButtonIcon;