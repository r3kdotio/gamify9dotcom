import { Response } from '@angular/http';

export class BaseChallengeComponent {
    //null means not attemped, true means success, false means failure
    success : Boolean;
    errorMessage = null;

    evaluateResponse(res: Response) {
        console.info("Success");
        this.success = true;
        this.errorMessage = null;
    }

    error(error) {
        console.info("Error " + error.json().message);
        this.errorMessage = error.json().message;
        this.success = false;
    }
}