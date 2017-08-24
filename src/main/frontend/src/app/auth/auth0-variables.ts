interface AuthConfig {
  clientID: string;
  domain: string;
  callbackURL: string;
}

export const AUTH_CONFIG: AuthConfig = {
  clientID: '4xWiJnaIoWtecofOdVGKdrrDWEPIc3eo',
  domain: 'gamify9.auth0.com',
  callbackURL: 'http://localhost:8080/callback'
};
