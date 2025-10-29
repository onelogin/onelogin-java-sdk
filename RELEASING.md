# Releasing to Maven Central

This document describes how to publish releases of the OneLogin Java SDK to Maven Central.

## Prerequisites

Before releasing, ensure you have:

1. **Sonatype OSSRH Account**: Register at https://issues.sonatype.org/
2. **GPG Key**: Generate a GPG key pair for signing artifacts
3. **GitHub Secrets**: Configure the following secrets in the repository:
   - `OSSRH_USERNAME`: Your Sonatype OSSRH username
   - `OSSRH_TOKEN`: Your Sonatype OSSRH password/token
   - `GPG_PRIVATE_KEY`: Your GPG private key (export with `gpg --armor --export-secret-keys YOUR_KEY_ID`)
   - `GPG_PASSPHRASE`: The passphrase for your GPG key

## Release Process

The release process is automated via GitHub Actions:

1. **Update Version**: Update the version in `pom.xml` and `build.gradle` to the new release version (e.g., `3.1.3`)

2. **Create a Git Tag**: Tag the release commit
   ```bash
   git tag -a v3.1.3 -m "Release version 3.1.3"
   git push origin v3.1.3
   ```

3. **Create GitHub Release**: Go to https://github.com/onelogin/onelogin-java-sdk/releases/new
   - Choose the tag you just created
   - Fill in the release title and description
   - Click "Publish release"

4. **Automated Publishing**: The GitHub Actions workflow will automatically:
   - Build the project
   - Sign the artifacts with GPG
   - Deploy to Maven Central via OSSRH
   - Automatically release the artifacts (due to `autoReleaseAfterClose` configuration)

5. **Verify**: After the workflow completes, verify the release appears at:
   https://repo1.maven.org/maven2/com/onelogin/onelogin-java-sdk/

## Manual Release (if needed)

If you need to manually publish a release:

```bash
# Ensure you have configured your ~/.m2/settings.xml with OSSRH credentials
mvn clean deploy -P sign-artifacts
```

Your `~/.m2/settings.xml` should contain:

```xml
<settings>
  <servers>
    <server>
      <id>ossrh</id>
      <username>${env.OSSRH_USERNAME}</username>
      <password>${env.OSSRH_PASSWORD}</password>
    </server>
  </servers>
</settings>
```

Note: Replace `${env.OSSRH_USERNAME}` and `${env.OSSRH_PASSWORD}` with your actual credentials or use environment variables.

## Troubleshooting

### Release Not Appearing on Maven Central

1. Check the GitHub Actions workflow logs
2. Verify all secrets are correctly configured
3. Check the Sonatype OSSRH Nexus Repository Manager at https://oss.sonatype.org/
4. Note: It can take up to 2 hours for releases to sync to Maven Central

### GPG Signing Issues

Ensure your GPG key is:
- Uploaded to a public key server (e.g., `gpg --keyserver keys.openpgp.org --send-keys YOUR_KEY_ID`)
- Not expired
- Has the correct passphrase configured in GitHub secrets

## References

- [OSSRH Guide](https://central.sonatype.org/publish/publish-guide/)
- [Maven GPG Plugin](https://maven.apache.org/plugins/maven-gpg-plugin/)
- [Nexus Staging Maven Plugin](https://github.com/sonatype/nexus-maven-plugins/tree/main/staging/maven-plugin)
