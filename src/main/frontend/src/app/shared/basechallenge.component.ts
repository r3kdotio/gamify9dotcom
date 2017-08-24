import { Response } from '@angular/http';

export class BaseChallengeComponent {
    successs = false;
    errorMessage = null;

    evaluateResponse(res: Response) {
        console.info("Success");
        this.successs = true;
    }

    error(error) {
        console.info("Error " + error.json().message);
        this.errorMessage = error.json().message;
        this.successs = false;
    }
}